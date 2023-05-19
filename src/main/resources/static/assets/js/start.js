// import * as timer from './timer';

(() => {
    document.querySelector('.hiddenBtn').click();
    calRound();
    selectOne();

})();

// 게임 라운드 정하기 함수

function calRound() {

    const playerNum = document.getElementById('game').dataset.playerCount;
    let n = 2;
    while (playerNum >> n > 0) {

        const $option = document.createElement('option');
        $option.value = `${2 ** n}`;
        console.log($option.value);
        $option.textContent = 2 ** n + '강';
        document.getElementById('round').appendChild($option);
        n++;

    }
    selectRound();
}

// 모달 확인 버튼 클릭시 PlayerController에서 playingGameId를 받아온다.
function selectRound() {
    document.getElementById('send').onclick = e => {
        const selectedValue = document.getElementById('round').value;

        sendRoundToPlayerController(selectedValue);

    }

}

// PlayerController 로 데이터 전달
function sendRoundToPlayerController(round) {
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
                    ({currentRound, randomTwoPlayers}) => {
                        renderRoundInfo(currentRound);
                        renderPlayers(randomTwoPlayers);
                    }
                );
        }, 3000);

    }
}

// 모달 확인 버튼 클릭시 게임 시작
function renderPlayers(randomTwoPlayers) {
    const arr = ['left', 'right'];
    for (let i = 0; i < 2; i++) {
        const {playerId, playerImgPath, playerName} = randomTwoPlayers[i];

        const $section = document.createElement('section')
        $section.setAttribute('class', arr[i]);
        $section.setAttribute('data-player-id', playerId);
        $section.style.backgroundImage = `url(${playerImgPath})`;
        $section.textContent = playerName;
        document.getElementById('game').appendChild($section);
        // console.log($section);
    }

}

// 게임 이름과 몇강인지 표시하는 함수
function renderGameInfo() {
    const $gameTitle = document.getElementById('game-title-wrapper');
}