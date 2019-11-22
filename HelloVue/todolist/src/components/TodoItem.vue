<template>
  <div>
  <li class="item" @click='deleteItem'>{{content}} {{index}}</li>
  </div>
</template>

<script>
export default {
    props: ["content", "index"],
    methods: {
        handleClick: function() {
            alert('每一个组件都是vue实例');
        },
        deleteItem: function() {
            this.$emit("delete", this.index);
        }
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .item {
        color: green;
    }
</style>
