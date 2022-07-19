<template>
    <div>
        <h2>Home Content</h2>
        <p>name: {{name}} age: {{age}}</p>
        <p>length: {{length}}</p>
    </div>
</template>

<script>
    export default {
        inject: ['name', 'age', 'length']
    }
</script>

<style lang="scss" scoped>

</style>