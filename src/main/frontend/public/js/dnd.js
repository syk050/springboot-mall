function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("dragElement", ev.target.id);
}

function drop(ev) {
    ev.preventDefault();

    const data = ev.dataTransfer.getData("dragElement");
    if (ev.target.classList.contains("w3-tag")){
        ev.target.parentNode.appendChild(document.getElementById(data));
    }else{
        ev.target.appendChild(document.getElementById(data));
    }
}