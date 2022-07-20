<template>
    <div>
        Home组件
        {{name}}
    </div>
</template>

<script>
    export default {
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