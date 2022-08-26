// document.addEventListener('DOMContentLoaded', (event) => {
//
//     let dragSrcEl = null;
//
//     function handleDragStart(e) {
//         this.style.opacity = '0.4';
//
//         dragSrcEl = this;
//
//         e.dataTransfer.setData('dragElement', e.target.id);
//         e.dataTransfer.effectAllowed = 'move';
//     }
//
//     function handleDragOver(e) {
//         if (e.preventDefault) {
//             e.preventDefault();
//         }
//
//         e.dataTransfer.dropEffect = 'move';
//
//         return false;
//     }
//
//     function handleDragEnter(e) {
//         this.classList.add('over');
//     }
//
//     function handleDragLeave(e) {
//         this.classList.remove('over');
//     }
//
//     function handleDrop(e) {
//         if (e.stopPropagation) {
//             e.stopPropagation(); // stops the browser from redirecting.
//         }
//
//         const data = e.dataTransfer.getData("dragElement");
//         if (e.target.classList.contains("w3-tag")){
//             e.target.parentNode.appendChild(document.getElementById(data));
//         }else{
//             e.target.appendChild(document.getElementById(data));
//         }
//
//         return false;
//     }
//
//     function handleDragEnd(e) {
//         this.style.opacity = '1';
//
//         dndBox.forEach(function (box) {
//             box.classList.remove('over');
//         });
//     }
//
//
//     const tags = document.querySelectorAll('.dnd-box .w3-tag');
//     tags.forEach(function(tag) {
//         tag.setAttribute("draggable", "true")
//         tag.addEventListener('dragstart', handleDragStart, false);
//         tag.addEventListener('dragend', handleDragEnd, false);
//     });
//
//     const dndBox = document.querySelectorAll('.dnd-box');
//     dndBox.forEach(box => {
//         box.addEventListener('dragenter', handleDragEnter, false);
//         box.addEventListener('dragleave', handleDragLeave, false);
//         box.addEventListener('dragover', handleDragOver, false);
//         box.addEventListener('drop', handleDrop, false);
//     })
// });

const dnd = {
    dragSrcEl: null,
    tags: null,
    dndBox: null,


    init() {
        const _this = this;

        _this.tags = document.querySelectorAll('.dnd-box .w3-tag');
        _this.tags.forEach(function(tag) {
            tag.setAttribute("draggable", "true")
            tag.addEventListener('dragstart', _this.handleDragStart, false);
            tag.addEventListener('dragend', _this.handleDragEnd, false);
        });

        _this.dndBox = document.querySelectorAll('.dnd-box');
        _this.dndBox.forEach(box => {
            box.addEventListener('dragenter', _this.handleDragEnter, false);
            box.addEventListener('dragleave', _this.handleDragLeave, false);
            box.addEventListener('dragover', _this.handleDragOver, false);
            box.addEventListener('drop', _this.handleDrop, false);
        })
    },
    handleDragStart(e) {
        this.style.opacity = '0.4';

        this.dragSrcEl = this;

        e.dataTransfer.setData('dragElement', e.target.id);
        e.dataTransfer.effectAllowed = 'move';
    },
    handleDragEnd() {
        this.style.opacity = '1';

        _this.dndBox.forEach(function (box) {
            box.classList.remove('over');
        });
    },
    handleDragEnter() {
        this.classList.add('over');
    },
    handleDragLeave() {
        this.classList.remove('over');
    },
    handleDragOver(e) {
        if (e.preventDefault) {
            e.preventDefault();
        }

        e.dataTransfer.dropEffect = 'move';

        return false;
    },
    handleDrop(e) {
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
}

dnd.init();