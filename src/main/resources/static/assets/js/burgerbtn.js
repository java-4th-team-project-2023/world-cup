// 클릭 이벤트 추가
document.addEventListener('click', function (event) {
  const icon = document.getElementById('icon');
  const menu = document.querySelector('.inr-menu');

  if (!menu.contains(event.target) && event.target !== icon) {
    icon.checked = false;
  }
});
