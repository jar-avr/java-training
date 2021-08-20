function revealTypeIfUser() {
        if (document.getElementById('gridRadios1').checked) {
            document.getElementById('ToBeRevealed').style.display = 'block';
        } else {
            document.getElementById('ToBeRevealed').style.display = 'none';
        }
}