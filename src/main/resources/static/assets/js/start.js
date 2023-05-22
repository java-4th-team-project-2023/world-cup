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
        // console.log($option.value);
        $option.textContent = 2 ** n + '강';
        document.getElementById('round').appendChild($option);
        n++;

    }
    selectRound();
}

// 모달 확인 버튼 클릭시 PlayerController에서 playingGameId를 받아온다.
async function selectRound() {
    document.getElementById('send').onclick = async e => {
        const selectedValue = document.getElementById('round').value;

        await sendRoundToPlayerController(selectedValue);

        addResetEvent();

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


// 대결 player 선택하고 게임 다시시작
    function selectOne() {
        const $game = document.getElementById('game');

        $game.onclick = e => {
            console.log(e.target.dataset.playerId);
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

// 모달 확인 버튼 클릭시 게임 시작, 다음 게임 시작
    function startGame() {
        const arr = ['left', 'right'];
        for (let i = 0; i < 2; i++) {
            let $section = document.createElement('section')
            $section.setAttribute('class', arr[i]);
            $section.setAttribute('data-player-id', i);
            document.getElementById('game').appendChild($section);
            console.log($section);
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
}