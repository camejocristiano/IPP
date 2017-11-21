import { TreinoPage } from './app.po';

describe('treino App', () => {
  let page: TreinoPage;

  beforeEach(() => {
    page = new TreinoPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
