<template>
    <div>
        <button @click="isShow = !isShow">切换</button>
        <template v-if="isShow">
            <Home></Home>
        </template>
        
    </div>
</template>

<script>
import Home from "./Home.vue";
export default {
    components: { Home },
    data() {
        return {
            isShow: true
        }
    },
};
</script>

<style lang="scss" scoped></style>
