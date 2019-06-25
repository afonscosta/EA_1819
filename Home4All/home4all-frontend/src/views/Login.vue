<template>
  <div id="login">
    <h1> Login </h1>

    <!-- <facebook-login class="button"
      appId="1326428550840901"
      @login="getUserData"
      @logout="onLogout"
      @get-initial-status="getUserData">
    </facebook-login> -->

    <hr class="hr-text" data-content="OR">

    <div class="row">
      <div class="col-md">
        <hr class="left-hr" style="width: 20%">
      </div>
      <div class="col-md-1" style="width: 20px;">
        OU
      </div>
      <div class="col-md">
        <hr class="right-hr" style="width: 20%">
      </div>
    </div>

    <div class="centered">
      <input v-on:input="invalidCredencials = false" class="email-input" type="text" name="email" v-model="input.email" placeholder="Endereço de email">
    </div>
    <div class="centered">
      <input v-on:input="invalidCredencials = false" class="password-input" type="password" name="password" v-model="input.password" placeholder="Palavra-passe">
    </div>

    <div class="alertMessage">
      <b-alert v-model="invalidCredencials" variant="danger" dismissible>
        Credenciais inválidas.
      </b-alert>
    </div>

    <button class="button" type="button" v-on:click="loginButton()"> Entrar </button>

    <button class="button" type="button" v-on:click="testeButton()"> teste </button>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import facebookLogin from 'facebook-login-vuejs'

export default {
  name: 'login',
  data () {
    return {
      input: {
        email: '',
        password: ''
      },
      invalidCredencials: false,
      isConnected: false,
      name: '',
      personalID: '',
      FB: undefined
    }
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
          this.$router.push('/')
        }).catch(errorResponse => {
          if (errorResponse.status === 403) {
            console.log('credenciais inválidas')
            this.invalidCredencials = true
          } else {
            console.log('não foi possível efetuar a ligação ao servidor aplicacional')
          }
        })
      }
    },
    testeButton () {
      this.teste()
        .then(() => {
          console.log('correu bem')
        })
        .catch(error => {
          console.log(error)
        })
    },
    getUserData () {
      this.FB.api('/me', 'GET', { fields: 'id,name,email' },
        userInformation => {
          this.personalID = userInformation.id
          this.email = userInformation.email
          this.name = userInformation.name
        }
      )
    },
    sdkLoaded (payload) {
      this.isConnected = payload.isConnected
      this.FB = payload.FB
      if (this.isConnected) this.getUserData()
    },
    onLogin () {
      this.isConnected = true
      this.getUserData()
    },
    onLogout () {
      this.isConnected = false
    }
  },
  components: {
    facebookLogin
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
  width: 400px;
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
