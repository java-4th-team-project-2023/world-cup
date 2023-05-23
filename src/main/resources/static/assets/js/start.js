// import * as timer from './timer';

(() => {
    checkExistGame();
    selectOne();
})();

function newGame() {
    document.querySelector('.hiddenBtn').click();
    calRound();
}

// 하던 게임이 있는지 확인하는 함수
function checkExistGame() {


    const $inrMenu = document.querySelector('.inr-menu');

    const accountId = ($inrMenu === null) ? '' : $inrMenu.dataset.accountId;

    fetch(`/api/v1/plays/${accountId}/${document.getElementById('game').dataset.gameId}`)
        .then(res => {
            if (res.status === 500) {
                newGame();
                console.log('새 게임!');
            } else return res.json();
        })
        .then(playingGameId => {
            fetch(`/api/v1/plays/${playingGameId}`)
                .then(res => res.json())
                .then(({totalRound, currentRound, randomTwoPlayers}) => {
                    renderPlayers(randomTwoPlayers);
                    renderRoundInfo(currentRound);
                    document.getElementById('game').dataset.playingGameId = playingGameId;
                });
        })
}

// 게임 라운드 정하기 함수
function calRound() {

    const playerNum = document.getElementById('game').dataset.playerCount;
    let n = 2;
    while (playerNum >> n > 0) {

        const $option = document.createElement('option');
        $option.value = `${2 ** n}`;
        // console.log($option.value);
        $option.textContent = 2 ** n + '강';
        document.getElementById('round').appendChild($option);
        n++;

    }
    selectRound().then();
}

// 모달 확인 버튼 클릭시 PlayerController에서 playingGameId를 받아온다.
async function selectRound() {
    document.getElementById('send').onclick = async e => {
        const selectedValue = document.getElementById('round').value;

        await sendRoundToPlayerController(selectedValue);

        addResetEvent();

    }

    document.getElementById('close').onclick = e => {
        history.back();
    }

}

// PlayerController 로 데이터 전달
async function sendRoundToPlayerController(round) {
    fetch(`/api/v1/players/${document.getElementById('game').dataset.gameId}/num/${round}`,
        {
            method: 'POST'
        })
        .then(res => res.json())
        .then(
            playingGameId => {
                fetch(`/api/v1/plays/${playingGameId}`)
                    .then(res => res.json())
                    .then(({totalRound, currentRound, randomTwoPlayers}) => {
                        renderPlayers(randomTwoPlayers);
                        renderRoundInfo(currentRound);
                        document.getElementById('game').dataset.playingGameId = playingGameId;
                    });
            }
        );
}

// 현재 라운드 정보를 뿌려준다
function renderRoundInfo(currentRound) {
    document.getElementById('round-info').textContent = currentRound + '강';
}

// 클릭하면 커지는 이벤트 등록
function selectOne() {
    const $game = document.getElementById('game');

    $game.onclick = e => {
        const winnerId = e.target.dataset.playerId;
        const loserId = (e.target.matches('.left') ?
            document.querySelector('.right').dataset.playerId : document.querySelector('.left').dataset.playerId);


        e.target.classList.add('bigger');
        setTimeout(() => {
            e.target.classList.remove('bigger');

            $game.textContent = '';
            fetch(`/api/v1/plays/${$game.dataset.playingGameId}/${winnerId}/${loserId}`,
                {
                    method: 'PUT'
                })
                .then(res => res.json())
                .then(
                    ({totalRound, currentRound, randomTwoPlayers, gameId}) => {

                        if (currentRound === 0) {
                            window.location.href = `/rank/winner?gameId=${gameId}&playerId=${winnerId}&round=${totalRound}`;
                        }

                        renderRoundInfo(currentRound);
                        renderPlayers(randomTwoPlayers);
                    }
                );
        }, 2000);

    }
}

// 모달 확인 버튼 클릭시 게임 시작
function renderPlayers(randomTwoPlayers) {
    const arr = ['left', 'right'];
    for (let i = 0; i < 2; i++) {
        const {playerId, playerImgPath, playerName} = randomTwoPlayers[i];

        const $section = document.createElement('section');
        $section.setAttribute('class', arr[i]);
        $section.setAttribute('data-player-id', playerId);
        $section.style.backgroundImage = `url(${playerImgPath})`;
        $section.textContent = playerName;
        document.getElementById('game').appendChild($section);
        // console.log($section);
    }

}

// 리셋 버튼 등록 함수
function addResetEvent() {
    document.getElementById("resetBtn").onclick = e => {
        const $game = document.getElementById('game');
        fetch(`/api/v1/plays/${$game.dataset.playingGameId}`,
            {
                method: 'PUT'
            })
            .then(res => {

                $game.textContent = '';

                return res.json();
            })
            .then(({randomTwoPlayers}) => renderPlayers(randomTwoPlayers));
    }
}