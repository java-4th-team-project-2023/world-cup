// 클릭 이벤트 추가
document.addEventListener('click', e => {
  const icon = document.getElementById('icon');
  const menu = document.querySelector('.inr-menu');

  if (icon.checked === true && ((!menu.contains(e.target) && e.target !== icon) || e.target.matches('.transition'))) {
    icon.checked = false;
  }
});
