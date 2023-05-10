// 햄버거 버튼
const transition = document.querySelector(".transition");
transition.addEventListener("click", handleClick);

function handleClick() {
    transition.classList.toggle("close");
}
// 햄버거 버튼