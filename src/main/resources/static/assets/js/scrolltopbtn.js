let topBtn = document.querySelector(".top-btn");

// On Click, Scroll to the page's top, replace 'smooth' with 'instant' if you don't want smooth scrolling
// 클릭 시 페이지의 상단으로 스크롤. 부드럽게 이동하는 것을 원치 않을 경우 'smooth'를 'instant'로 바꾸도록 합니다.
topBtn.onclick = () => window.scrollTo({ top: 0, behavior: "smooth" });

// On scroll, Show/Hide the btn with animation
// 스크롤 시 애니메이션과 함께 버튼 표시/숨기기
window.onscroll = () => window.scrollY > 500 ? topBtn.style.opacity = 1 : topBtn.style.opacity = 0