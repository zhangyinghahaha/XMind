<script setup>
import { useRouter, useRoute } from 'vue-router';

// const router = useRouter();
// const route = useRoute();
</script>

<template>
    <div>
        <!-- <h2>Hello, {{route.params.username}}</h2> -->
        <h2>User: {{$route.params.username}}</h2>
    </div>
</template>

<style scoped>

</style>