import statisticsService from '../../services/statisticsService'

const state = {
  statistics: {}
}

const getters = {
  statistics: state => {
    return state.statistics
  }
}

const mutations = {
  setStatistics (state, statistics) {
    state.statistics = statistics
  }
}

const actions = {
  getStatisticsInfo ({ commit }, payload) {
    statisticsService.fetchStatistics(payload).then(statistics => {
      console.log('STATISTICS')
      console.log(statistics.g1)
      commit('setStatistics', statistics)
    })
  }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
