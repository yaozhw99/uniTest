<template>
	<div id="app">
		{{message}}--{{age}}

    <button @click="emitEvent()">自定义事件</button>
	</div>

</template>

<script>
	export default {
	    props:{
	        message:String,
          age:{
	            type:Number,
              required:true
          }
      },
		data(){
			return {
				msg:'helloworld'
			}
		},
      methods:{
	        emitEvent() {
	            console.log('begin.....');
              this.$emit('sendMsg','子组件的参数');

          }
      }
	}
</script>

<style>
</style>
