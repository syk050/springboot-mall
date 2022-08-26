import MyUploadAdapter from "./MyUploadAdapter";
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";

function SimpleUploadAdapterPlugin(editor) {
    editor.plugins.get("FileRepository").createUploadAdapter = (loader) => {
        return new MyUploadAdapter(loader);
    };
}

class CustomCkeditor {
    constructor(target = "#editor", onCreate = () => {}) {
        this.target = target;

        this.onCreate = onCreate;
    }

    create(){
        return ClassicEditor.create( document.querySelector( '#ckeditor' ), {
            licenseKey: '',
            extraPlugins: [SimpleUploadAdapterPlugin],
        } ).then( editor => {
            window.editor = editor;

            // 세팅 완료 후 할일이 있다면
            this.onCreate();

        }).catch( error => {
            console.error( error );
        });
    }
}

export default CustomCkeditor