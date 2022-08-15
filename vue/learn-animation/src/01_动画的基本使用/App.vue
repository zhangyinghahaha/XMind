<template>
    <div>
        <button @click="toggle">显示/隐藏</button>
        <transition name="my-animation">
            <h2 v-if="isShow">Hello World</h2>
        </transition>
    </div>
</template>

<script>
export default {
    data() {
        return {
            isShow: true,
        };
    },
    methods: {
        toggle() {
            this.isShow = !this.isShow;
        },
    },
};
</script>

<style scoped>
.my-animation-enter-from,
.my-animation-leave-to {
    opacity: 0;
}

.my-animation-enter-to,
.my-animation-leave-from {
    opacity: 1;
}

.my-animation-enter-active,
.my-animation-leave-active {
    transition: opacity 2s ease;
}
</style>
