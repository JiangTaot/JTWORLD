<template>
  <div id="test" class="test-class">
    你好
  </div>
  <img class="my-img" src="../../public/touxiang1.png"  alt="头像1"/>
   啊
</template>

<script setup>
</script>

<style scoped>
#test{
  color: red;
  padding: 10px 20px 5px 30px;
  border: #646cff solid 1px;
  margin: 20px 10px 30px 10px;
  background-color: aquamarine;
  text-shadow: -10px 5px 1px blue;
  width: 600px;
  display: block;
}

.my-img {
  margin: 10px 10px 20px 30px;
  display: block;
  width: 100px;
}

div[class="test-class"] {
  color: orange;
}

div[id="test"] {
  color: yellow;
}

.test-class {
  color: blue;
}

div {
  color: green;
}


</style>