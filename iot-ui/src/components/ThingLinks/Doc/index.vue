<template>
  <div>
    <svg-icon icon-class="question" @click="goto"/>
  </div>
</template>

<script>
export default {
  name: 'basiclabiotDoc',
  data() {
    return {
      url: 'http://doc.basiclabiot.iot.com'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>
