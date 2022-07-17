<template>
    <div class="main">
        <MainBanner></MainBanner>
        <ProductList></ProductList>
    </div>
</template>

<script>
import MainBanner from "./MainBanner.vue";
import ProductList from "./ProductList.vue";

export default { components: { MainBanner, ProductList } };
</script>

<style scoped></style>
