  const deleteBtn = document.querySelector('.rpboard-delete-replies-btn');
  const checkText = document.querySelector('.rpboard-delete-check-replies-text');

  deleteBtn.addEventListener('click', (event) => {
      event.stopPropagation(); // 클릭 이벤트 전파 방지
      checkText.style.display = checkText.style.display === 'block' ? 'none' : 'block';
  });

  document.addEventListener('click', (event) => {
      const target = event.target;
      if (!target.closest('.rpboard-delete-check-replies-text') && !target.closest('.rpboard-delete-replies-btn')) {
          checkText.style.display = 'none';
      }
  });