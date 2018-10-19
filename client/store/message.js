export const state = () => ({
  list: []
})

export const mutations = {

  addMessage(state,message){

    state.list.push({
      id:Math.random(),
      sender:message.sender,
      receiver:message.receiver,
      text:message.text
      ,
    })
  },
}

export const actions = {


}
