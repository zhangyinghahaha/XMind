<template>
    <div>
        <h2 class="title">App</h2>
        <HelloWorld></HelloWorld>
    </div>   
</template>

<script>
import HelloWorld from "./HelloWorld.vue";
export default {
    components: { HelloWorld },
};
</script>

<style scoped>
.title {
    color: red;
}
</style>
