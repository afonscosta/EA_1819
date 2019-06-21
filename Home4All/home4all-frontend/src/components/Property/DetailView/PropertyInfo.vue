<template>
  <b-card
    border-variant="secondary"
    header="Informação Geral"
    header-border-variant="secondary"
  >
    <p>Descrição: {{ description }}</p>
    <b-row>
      <b-col>
        <p>Imóvel: {{ type }}</p>
      </b-col>
      <b-col>
        <p>Tipologia: {{ typology }}</p>
      </b-col>
      <b-col>
        <p>Área: {{ area }}</p>
      </b-col>
    </b-row>

    <b-row>
      <b-col>
        <p>Distrito: {{ district }}</p>
      </b-col>
      <b-col>
        <p>Cidade: {{ city }}</p>
      </b-col>
    </b-row>

    <p>Endereço completo: {{ address }}</p>
    <p>Latitude: {{ lat }}</p>
    <p>Longitude: {{ lng }}</p>

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
          v-model="totalAccess"
          name="checkbox-totalAccess"
          class="pb-2"
          disabled
        >Acesso total</b-form-checkbox>
      </b-col>
    </b-row>

    <b-row>
      <b-col>
        <p v-if="type !== 'bedrooms'">Disponível a partir de: {{ availability }}</p>
      </b-col>
      <b-col v-if="type !== 'bedrooms' && rent && !sell">
        <p>Operação: arrendar</p>
      </b-col>
      <b-col v-if="type !== 'bedrooms' && !rent && sell">
        <p>Operação: vender</p>
      </b-col>
      <b-col v-if="type !== 'bedrooms' && rent && sell">
        <p>Operação: vender/arrendar</p>
      </b-col>
    </b-row>

    <b-row>
      <b-col>
        <p v-if="type !== 'bedrooms' && rent">Mensalidade: {{ rentPrice }}</p>
      </b-col>
      <b-col>
        <p v-if="type !== 'bedrooms' && sell">Preço total: {{ sellPrice }}</p>
      </b-col>
    </b-row>
  </b-card>
</template>

<script>
export default {
  name: 'PropertyInfo',
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
  }
}
</script>
