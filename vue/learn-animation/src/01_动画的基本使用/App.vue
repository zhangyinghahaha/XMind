<template>
    <div>
        <button @click="toggle">显示/隐藏</button>
        <transition name="my" type="animation">
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
/* .my-animation-enter-from,
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
} */
.my-enter-active {
    animation: bounce 1s ease;
}

.my-leave-active {
    animation: bounce 1s ease reverse;
}

@keyframes bounce {
    0% {
        transform: scale(0);
    }
    50% {
        transform: scale(1.2);
    }
    100% {
        transform: scale(1);
    }
}
</style>
