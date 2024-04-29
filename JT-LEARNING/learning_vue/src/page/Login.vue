<template>
  <div id="test" class="test-class">
    你好
  </div>
  <img class="my-img" src="../../public/touxiang1.png"  alt="头像1"/>
   啊

  <h1 class="my-h1"><span>我是一级标题</span></h1>

  <p>
    这是一个段落文本。在文本中有一个 <span>span element</span> 并且还有一个
    <a href="http://example.com">链接</a>.
  </p>

  <p>这是第二段。包含了一个 <em>强调</em> 元素。</p>

  <ul>
    <li class="special">项目 1</li>
    <li>项目 2</li>
    <li>项目 <em>三</em></li>
  </ul>

  <p class="my-p">乱树飞花</p>

  <p class="my-pp">测试</p>
</template>

<script setup>
</script>

<style scoped>
.my-p {
  background-color: pink;
}

/* 条件 */
@media (min-width: 30em) {
  .my-p {
    background-color: yellow;
  }
}

.my-pp {
  background-color: red; /*背景颜色 红色*/
  background-image: url(touxiang1.png);/*背景图片 在public中*/
  background-position: 10px 10px;
  background-repeat: repeat-x;
  background-attachment: fixed;
}


a:hover {
  color: pink;
}

h1 + p {
  font-size: 200%;
}

/*a:link {*/
/*  color: pink;*/
/*}*/

/*a:visited {*/
/*  color: green;*/
/*}*/

h1 {
  background: -webkit-linear-gradient(315deg, #42d392 25%, #647eff);
  -webkit-background-clip: text;
  color: transparent;
}

li {
  color: green;
  list-style-type: "\1F44D";
}

.special {
  color: orange;
  font-weight: bold;
}

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