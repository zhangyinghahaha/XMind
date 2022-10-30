<script setup>
import Home from './views/Home.vue';
import About from './views/About.vue';
</script>

<template>
    <h2>Hello, Vue-Router!</h2>
    <RouterLink to="/home">首页</RouterLink>
    <RouterLink to="/about">关于</RouterLink>
    <RouterView></RouterView>
</template>

<style scoped>

</style>