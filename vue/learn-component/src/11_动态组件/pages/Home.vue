<template>
    <div>
        Home组件
        {{name}}
    </div>
</template>

<script>
    export default {
        name: 'home',
        props: {
            name: {
                type: String,
                default: ''
            },
        },
    }
</script>

<style lang="scss" scoped>

</style>