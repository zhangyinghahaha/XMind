<script setup>
import { ref } from 'vue';
import RoomArea from './components/RoomArea.vue';
// 获取数据
// import highScore from './data/high_score.json';
const highScore = ref({});

setTimeout(() => {
    import('./data/high_score.json').then(data => highScore.value = data)
}, 1000);
</script>

<template>
    <div class="app">
        <RoomArea :area-data="highScore"></RoomArea>
    </div>
</template>

<style lang="less" scoped>
  .app {
    width: 1032px;
    padding: 40px;
    margin: 0 auto;
  }
</style>