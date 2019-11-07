<template>

		<button>{{message}}</button>

</template>

<script>
	export default {
	    props:['message'],
		data(){
			return{
				msg:'提交'
			}
		}
	}
</script>

<style>
	button{
		border: 1px solid #42B983;
		padding: 10px 20px;
		font-size: 1.625rem;
	}
</style>
