var TERMS = 12; //number of terms in a year

function sel(s) {
    return document.querySelector(s);
}

function populateYearGrid() {
    var grid = sel('.yeargrid');
    for (var i = 0; i < TERMS; i++) {
        var c = document.createElement('div');
        c.setAttribute('class', 'termbox');
        grid.appendChild(c);
    }
}

window.onload = function() {
    populateYearGrid();
}
