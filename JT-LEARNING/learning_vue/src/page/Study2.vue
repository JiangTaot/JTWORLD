<template>
  <h1></h1>
  <div class="datetime">2024-04-30</div>
  <article>
    <p>
      <span>早上起来腰酸，可能的原因是，受凉、床垫不好、腰肌劳损</span><br/>
      <span>可太难受了</span>
    </p>
    <p>
      对于腰肌劳损，如何修复
    </p>
    <p>
      锻炼：小燕飞、山羊站立、瑜伽或普拉提
    </p>
  </article>

  <article>
    <p class="box">利用热敷</p>
  </article>

  <form>
    <label for="name">姓名：</label>
    <input type="text" id="name" name="name"/>
    <label for="email">email：</label>
    <input type="email" id="email" name="email">
    <label><input class="todo" name="todo" type="checkbox" required checked/>今日必做</label>
  </form>


  <ul>
    <li>Unordered item</li>
    <li>Unordered item
      <ol>
        <li>Item 1</li>
        <li>Item 2</li>
      </ol>
    </li>
  </ul>


  <div class="container">
    <h1>This is a heading</h1>
    <p>Veggies es <span>bonus vobis</span>, proinde <span>vos postulo</span> essum magis kohlrabi welsh onion daikon amaranth tatsoi tomatillo melon azuki bean garlic.</p>
    <h2>A level 2 heading</h2>
    <p>Gumbo beet greens <span>corn soko</span> endive gumbo gourd. Parsley shallot courgette tatsoi pea sprouts fava bean collard greens dandelion okra wakame tomato. Dandelion cucumber earthnut pea peanut soko zucchini.</p>

  </div>

  <div class="container2">
    <h1>This is a heading</h1>
    <p>Veggies es <span class="alert">bonus vobis</span>, proinde vos postulo <span class="alert stop">essum magis</span> kohlrabi welsh onion daikon amaranth tatsoi tomatillo melon azuki bean garlic.</p>
    <h2 id="special">A level 2 heading</h2>
    <p>Gumbo beet greens corn soko endive gumbo gourd.</p>
    <h2>Another level 2 heading</h2>
    <p><span class="alert go">Parsley shallot</span> courgette tatsoi pea sprouts fava bean collard greens dandelion okra wakame tomato. Dandelion cucumber earthnut pea peanut soko zucchini.</p>

  </div>
</template>

<script setup>
</script>

<style scoped>
.container2 #special {
  background-color: yellow;
  color: black;
}

.container2 .alert {
  border: 1px solid silver;
}

.container2 .alert.stop {
  background-color: red;
}

.container2 .alert.go {
  background-color: green;
}

h1 {
  color: blue;
}

h2 {
  color: white;
  background-color: blue;
}

.container p span{
  font-size: 200%;
}


ul > li {
  border-bottom: 5px solid red;
}

.box::before {
  content: "";
  display: block;
  width: 100px;
  height: 100px;
  background-color: rebeccapurple;
  border: 1px solid black;
}

/*article标签中 p标签 第一个子标签样式*/
article p:first-child {
  font-weight: bold; /*字体加粗*/
}
article p:first-child::first-line {
  color: aqua;
}

article p:last-child {
  color: #646cff;
}

article p:only-child {
  text-decoration: underline;
}

label {
  display: block;
  margin-top: 1em;
}

input:invalid {
  background-color: ivory;
  border: none;
  outline: 2px solid red;
  border-radius: 5px;
}

input:focus {
  background-color: #32a1ce;
}

input:hover {
  background-color: antiquewhite;
}
</style>