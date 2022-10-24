<script setup>
import RoomArea from './components/RoomArea.vue';
// 获取数据
import highScore from './data/high_score.json';
console.log(highScore);
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