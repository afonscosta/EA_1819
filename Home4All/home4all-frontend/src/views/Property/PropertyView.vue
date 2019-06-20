<template>
  <div>
    <h3 class="title">{{ property.name }}</h3>
    <b-button @click="$router.push({ name: 'propertyEdit' })" variant="danger">Editar</b-button>
    <b-container>
      <b-row class="justify-content-md-center">
        <b-col>
          <label>Nome: {{ property.name }}</label>
          <b-card-group deck class="deck-images-prop-info">
            <Images images="property.images" class="images"/>
            <PropertyInfo
              :description="property.description"
              :type="property.type"
              :typology="property.typology"
              :area="property.area"
              :district="property.district"
              :city="property.city"
              :address="property.address"
              :furnished="property.furnished"
              :availability="property.availability"
              :operation="property.operation"
              :rentPrice="property.rentPrice"
              :sellPrice="property.sellPrice"/>
          </b-card-group>

          <Bedroom
            :type="property.type"
            :bedroom="property.bedroom"/>

          <PresentTenants
            :type="property.type"
            :shared="property.shared"
            class="present-tenants"/>

          <b-card-group deck>
            <RentInclude :rentInc="property.rentInc"/>
            <DivEquipInclude :divEquipInc="property.divEquipInc"/>
          </b-card-group>

          <TenantsWanted
            class="tenants-wanted"
            :genre="property.genre"
            :allowedMinAge="property.allowedMinAge"
            :allowedMaxAge="property.allowedMaxAge"
            :ocupation="property.ocupation"
            :allowedSmoker="property.allowedSmoker"
            :allowedPets="property.allowedPets"/>
          <b-button @click="$router.push({ name: 'propertyEdit' })" variant="danger">Editar</b-button>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import Bedroom from '@/components/Property/DetailView/Bedroom'
import DivEquipInclude from '@/components/Property/DetailView/DivEquipInclude'
import Images from '@/components/Property/DetailView/Images'
import PresentTenants from '@/components/Property/DetailView/PresentTenants'
import PropertyInfo from '@/components/Property/DetailView/PropertyInfo'
import RentInclude from '@/components/Property/DetailView/RentInclude'
import TenantsWanted from '@/components/Property/DetailView/TenantsWanted'

export default {
  name: 'property',
  components: {
    Bedroom,
    DivEquipInclude,
    Images,
    PresentTenants,
    PropertyInfo,
    RentInclude,
    TenantsWanted
  },
  data: () => ({
  }),
  computed: {
    ...mapState({
      property: state => state.properties.property
    })
  },
  methods: {
  }
}
</script>
