<script setup>
import { useRouter, useRoute } from 'vue-router';

const router = useRouter();
const route = useRoute();
</script>

<template>
    <div>
        <h2>About</h2>
        <p>This is about page.</p>
        <p>{{ $route.query }}</p>
    </div>
</template>

<style scoped>

</style>