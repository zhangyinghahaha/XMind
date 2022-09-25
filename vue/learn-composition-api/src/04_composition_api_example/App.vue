<template>
    <div>
        <h2>Counter: {{counter}}</h2>
        <h2>DoubleCounter: {{doubleCounter}}</h2>
        <button @click="increment">+1</button>
        <button @click="decrement">-1</button>

        <p class="content"></p>
        <div class="scroll">
            <div class="scroll-x">scrollx: {{scrollX}}</div>
            <div class="scroll-y">scrolly: {{scrollY}}</div>
        </div>
    </div>
</template>

<script>
    import {ref, computed} from 'vue';
    import useCounter from './hooks/useCounter';
    import useTitle from './hooks/title';
    import useScroll from './hooks/scroll';
    import useLocalStorage from './hooks/localStorage';
    export default {
        setup() {
            // counter
            const {counter, doubleCounter, increment, decrement} = useCounter();

            // title
            const title = useTitle('哈哈哈');
            setTimeout(() => {
                title.value = '我自动改';
            }, 3000);

            // 滚动位置
            const {scrollX, scrollY} = useScroll();

            // localStorage

            return {
                counter,
                doubleCounter,
                increment,
                decrement,
                scrollX,
                scrollY
            }
        }
    }
</script>

<style scoped>
.content {
    width: 3000px;
    height: 5000px;
}

.scroll {
    position: fixed;
    right: 30px;
    bottom: 30px;
}
</style>