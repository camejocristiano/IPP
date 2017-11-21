import { BuscacepPage } from './app.po';

describe('buscacep App', () => {
  let page: BuscacepPage;

  beforeEach(() => {
    page = new BuscacepPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
