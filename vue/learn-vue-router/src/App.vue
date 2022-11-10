<script setup>

</script>

<template>
    <RouterLink to="/home" custom>
        <template #="{ navigate, href, route }">
            <button @click="navigate">首页</button>
        </template>
    </RouterLink>
    <RouterLink to="/user/zhang-ying">用户</RouterLink>

    <RouterView></RouterView>
</template>

<style scoped>

</style>