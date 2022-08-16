document.addEventListener('DOMContentLoaded', (event) => {

    let dragSrcEl = null;

    function handleDragStart(e) {
        this.style.opacity = '0.4';

        dragSrcEl = this;

        e.dataTransfer.setData('dragElement', e.target.id);
        e.dataTransfer.effectAllowed = 'move';
    }

    function handleDragOver(e) {
        if (e.preventDefault) {
            e.preventDefault();
        }

        e.dataTransfer.dropEffect = 'move';

        return false;
    }

    function handleDragEnter(e) {
        this.classList.add('over');
    }

    function handleDragLeave(e) {
        this.classList.remove('over');
    }

    function handleDrop(e) {
        if (e.stopPropagation) {
            e.stopPropagation(); // stops the browser from redirecting.
        }

        const data = e.dataTransfer.getData("dragElement");
        if (e.target.classList.contains("w3-tag")){
            e.target.parentNode.appendChild(document.getElementById(data));
        }else{
            e.target.appendChild(document.getElementById(data));
        }

        return false;
    }

    function handleDragEnd(e) {
        this.style.opacity = '1';

        dndBox.forEach(function (box) {
            box.classList.remove('over');
        });
    }


    const tags = document.querySelectorAll('.dnd-box .w3-tag');
    tags.forEach(function(tag) {
        tag.setAttribute("draggable", "true")
        tag.addEventListener('dragstart', handleDragStart, false);
        tag.addEventListener('dragend', handleDragEnd, false);
    });

    const dndBox = document.querySelectorAll('.dnd-box');
    dndBox.forEach(box => {
        box.addEventListener('dragenter', handleDragEnter, false);
        box.addEventListener('dragleave', handleDragLeave, false);
        box.addEventListener('dragover', handleDragOver, false);
        box.addEventListener('drop', handleDrop, false);
    })
});