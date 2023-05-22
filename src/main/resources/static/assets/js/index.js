

const $cardWrpper = document.querySelector('.card-wrapper');

// 하나의 게임을 클릭할 때 게임 페이지로 이동 
$cardWrpper.onclick = e =>{
    const listno = document.querySelector('.card').dataset.cno;
    window.location.href = '/'+listno;
}