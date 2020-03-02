var vue = new Vue({
    el: '#app',
    data: {},

    methods: {
        findAll: function () {
            let _this = this //this 表示vue对象
            axios.get('/srt').then(function (response) {
                //this变成了window
                _this.fileList = response.data

            })
        },
        convert: function () {
            let formData = new FormData()
            formData.append('file', document.querySelector('input[type=file]').files[0])
            axios({
                url: '/srt',
                data: formData,
                method: 'post',
                headers: {'Content-Type': 'multipart/form-data'},
                withCredentials: true
            }).then(function (response) {
                alert('转换成功，请到原文件夹中查看')
            })
        }


    },
    created: function () {

    }

})




