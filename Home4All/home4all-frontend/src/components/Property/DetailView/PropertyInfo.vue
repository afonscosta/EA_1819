<template>
  <div>
    <b-modal
      ref="modal-map"
      centered
      size="lg"
      hide-footer title="Localização do imóvel"
    >
      <google-map :marker="marker"/>
    </b-modal>
    <b-card
      class="prop-card"
      border-variant="secondary"
      header="Informação Geral"
      header-border-variant="secondary"
    >
      <b-row>
        <b-col>
          <p class="description" align="left">{{ description }}</p>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <p><strong>Imóvel:</strong> {{ parseType(type) }}</p>
        </b-col>
        <b-col>
          <p><strong>Tipologia:</strong> {{ typology }}</p>
        </b-col>
        <b-col>
          <p><strong>Área:</strong> {{ area }} m²</p>
        </b-col>
      </b-row>

      <p align="left" class="ml-1 mb-0"><strong>Endereço:</strong></p>
      <p align="left" class="ml-1">{{ address }}</p>
      <b-button variant="primary"
        @click="openMap({ lat: lat, lng: lng})"
        class="local-button"
      >Localização</b-button>

      <b-row>
        <b-col>
          <b-form-checkbox
            id="checkbox-1"
            v-model="furnished"
            name="checkbox-1"
            class="pb-2"
            disabled
          >Mobilado</b-form-checkbox>
        </b-col>
        <b-col>
          <b-form-checkbox
            id="checkbox-totalAccess"
            v-model="totalAccessUpdate"
            name="checkbox-totalAccess"
            class="pb-2"
            disabled
          >Acesso total</b-form-checkbox>
        </b-col>
      </b-row>

      <b-row>
        <b-col cols="12" lg="4">
          <label v-if="type !== 'bedrooms'"><strong>Disponível a partir de:</strong>&nbsp;</label>
          <label v-if="type !== 'bedrooms'">{{ availability }}</label>
        </b-col>
        <b-col cols="12" lg="4" v-if="type !== 'bedrooms' && rent && !sell">
          <p><strong>Operação:</strong> arrendar</p>
        </b-col>
        <b-col cols="12" lg="4" v-if="type !== 'bedrooms' && !rent && sell">
          <p><strong>Operação:</strong> vender</p>
        </b-col>
        <b-col cols="12" lg="4" v-if="type !== 'bedrooms' && rent && sell">
          <p><strong>Operação:</strong> vender/arrendar</p>
        </b-col>
      </b-row>

      <b-row>
        <b-col cols="12" lg="6">
          <p v-if="type !== 'bedrooms' && rent"><strong>Mensalidade:</strong> {{ rentPrice }} €/mês</p>
        </b-col>
        <b-col cols="12" lg="6">
          <p v-if="type !== 'bedrooms' && sell"><strong>Preço total:</strong> {{ sellPrice }} €</p>
        </b-col>
      </b-row>
    </b-card>
  </div>
</template>

<script>
import GoogleMap from '@/components/GoogleMap'

export default {
  name: 'PropertyInfo',
  components: {
    GoogleMap
  },
  props: {
    description: {
      type: String
    },
    type: {
      type: String
    },
    typology: {
      type: String
    },
    area: {
      type: Number
    },
    district: {
      type: String
    },
    city: {
      type: String
    },
    address: {
      type: String
    },
    lat: {
      type: Number
    },
    lng: {
      type: Number
    },
    furnished: {
      type: Boolean
    },
    totalAccess: {
      type: Boolean
    },
    availability: {
      type: String
    },
    rent: {
      type: Boolean
    },
    sell: {
      type: Boolean
    },
    rentPrice: {
      type: Number
    },
    sellPrice: {
      type: Number
    }
  },
  data: () => ({
    marker: null
  }),
  computed: {
    totalAccessUpdate () {
      if (this.type === 'apartment' || this.type === 'villa') {
        return true
      }
      return this.totalAccess
    }
  },
  methods: {
    openMap (value) {
      this.marker = value
      this.$refs['modal-map'].show()
    },
    parseType (type) {
      if (type === 'bedrooms') {
        return 'Quartos'
      } else if (type === 'villa') {
        return 'Vivenda'
      } else if (type === 'apartment') {
        return 'Apartamento'
      }
    }
  }
}
</script>

<style scoped>
.description {
  word-wrap: break-word;
  max-height: 200px;
  overflow-y: auto;
}

.card-div {
  height: 400px;
}

@media (max-width: 576px) {
  .local-button {
    width: 90%;
    margin-bottom: 1rem;
  }
}
</style>
