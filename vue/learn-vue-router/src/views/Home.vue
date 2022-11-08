<script setup>
import { useRouter, useRoute } from 'vue-router';

const router = useRouter();
const route = useRoute();

function jumpToAbout() {
    router.push({
        path:'/about',
        query: {name: 'hahaha'}
    });
}
</script>

<template>
    <h2>Home</h2>
    <p>This is home page.</p>

    <router-link to="/home/product">商品</router-link>
    <router-link to="/home/message">消息</router-link>

    <button @click="jumpToAbout">关于</button>

    <RouterView></RouterView>
</template>

<style scoped>

</style>