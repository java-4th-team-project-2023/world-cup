const $searchText = document.getElementById('Search-Text');
const $SearchBtn = document.getElementById('Search-Btn');

function expansionText() {
    if($searchText.style.width === '0%') {
        $searchText.style.width = '90%';
        $searchText.style.border = '1px solid black';
    } else {
        $searchText.style.width = '0%';
        $searchText.style.border = 'none';
    }
}

$SearchBtn.onclick = e => {
    expansionText();
};
