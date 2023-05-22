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

// 라운드를 정해서 value값을 가져옴 
function selectRound() {
    document.getElementById('send').onclick = e => {
        const selectedValue = document.getElementById('round').value;
        console.log(selectedValue);
        startGame();
        // sendDataToServer(selectedValue);
    }

}


// 대결 player 선택하고 게임 다시시작 
function selectOne() {
    const $game = document.getElementById('game');
 
    $game.onclick = e => {
        console.log(e.target.dataset.playerId);
        e.target.classList.add('bigger');

        setTimeout(() => {
            e.target.classList.remove('bigger');
            $game.textContent='';
            startGame();
        }, 3000);       

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