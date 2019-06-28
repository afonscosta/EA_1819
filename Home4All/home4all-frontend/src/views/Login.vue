<template>
  <div id="login">
    <h1> Login </h1>

    <div class="centered">
      <input v-on:input="errorFlag = false" class="email-input" type="text" name="email" v-model="input.email" placeholder="Endereço de email">
    </div>
    <div class="centered">
      <input v-on:input="errorFlag = false" class="password-input" type="password" name="password" v-model="input.password" placeholder="Palavra-passe">
    </div>

    <div class="alertMessage">
      <b-alert v-model="errorFlag" variant="danger" dismissible>
        {{errorMessage}}
      </b-alert>
    </div>

    <button class="button" type="button" v-on:click="loginButton()"> Entrar </button>
  </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'

export default {
  name: 'login',
  data () {
    return {
      input: {
        email: '',
        password: ''
      },
      errorMessage: '',
      errorFlag: false
    }
  },
  computed: {
    ...mapState({
      isAdmin: state => state.login.isAdmin
    })
  },
  methods: {
    ...mapActions('login', ['login']),
    ...mapActions('users', ['teste']),
    loginButton () {
      if (this.input.email !== '' && this.input.password !== '') {
        this.login({
          email: this.input.email,
          password: this.input.password
        }).then(sessionID => {
          console.log('sessionID ' + sessionID)
          console.log('teste no login', this.isAdmin)
          if (this.isAdmin) {
            this.$router.push('/complaints')
          } else {
            this.$router.push('/')
          }
        }).catch(errorResponse => {
          console.log(errorResponse)
          if (errorResponse) {
            if (errorResponse.data) {
              let parser = new DOMParser()
              let htmlDoc = parser.parseFromString(errorResponse.data, 'text/html')
              let body = htmlDoc.getElementsByTagName('body')
              if (body[0]) {
                this.errorMessage = body[0].innerText
                this.errorFlag = true
              }
            }
          }
          console.log(this.errorMessage)
          console.log('não foi possível efetuar a ligação ao servidor aplicacional')
        })
      }
    }
  }
}
</script>

<style scoped>

.centered {
  text-align:center;
}

div {
  padding: 10px 5px;
}

.left-hr {
  position: absolute;
  right: 0px;
}

.right-hr {
  position: absolute;
  left: 0px;
}

.alertMessage {
  width: 410px;
  margin: auto;
}

@media (max-width: 576px) {
  input {
    width: 90% !important;
  }
}

#login {
  background: url('../assets/7.jpg') no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}

.button {
  background-color: rgb(241, 146, 2);
  border: none;
  color: rgb(44, 44, 44) ;
  font-weight: bold;
  padding: 20px;
  text-align: center;
  display: inline-block;
  border-radius: 6px;
  font-size: 18px;
  margin: 4px 2px;
  opacity: 0.8;
  width: 180px;
  height: 60px;
}

input {
  border: 2px solid rgb(197, 197, 197);
  width: 35%;
  font-size: 12pt;
}

.email-input {
  background-image: url(envelope.png);
  background-repeat: no-repeat;
  background-position: right center;
  background-origin: content-box;
  background-size: 2.5rem 1.8rem;
  padding: 10px;
}

.password-input {
  background-image: url(lock.png);
  background-repeat: no-repeat;
  background-position: right center;
  background-origin: content-box;
  background-size: 3rem 1.8rem;
  padding: 10px;
}

input::placeholder {
  color: rgb(43, 43, 43);
  font-weight: bold;
}

</style>
