// 클릭 이벤트 추가
document.addEventListener('mouseup', e => {
  const inrMenu = document.querySelector('.inr-menu');
  const checkbox = document.getElementById('icon');

  if (e.target.matches('.transition>span')) return;

  if (!inrMenu.contains(e.target) && checkbox.checked) {
    checkbox.checked = false;
  }
});