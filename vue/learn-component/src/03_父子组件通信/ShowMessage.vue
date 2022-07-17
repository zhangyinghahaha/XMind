<template>
    <div>
        <h2 :name="$attrs.name">{{title}}</h2>
        <p :="$attrs">{{content}}</p>
    </div>
    <div></div>
</template>

<script>
    export default {
        // props数组写法
        // props: ['title', 'content']
        // props对象写法
        props: {
            title: {
                type: String,
                required: true
            },
            content: {
                type: String,
                default: ''
            },
            hahaha: Number,
            info: {
                type: Object,
                default() {
                    return {name: 'hahaha'};
                }
            },
            messageInfo: String,
        },
        // inheritAttrs: false,
    }
</script>

<style lang="scss" scoped>

</style>