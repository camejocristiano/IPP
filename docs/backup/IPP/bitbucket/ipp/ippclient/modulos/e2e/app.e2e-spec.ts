import { ModulosPage } from './app.po';

describe('modulos App', () => {
  let page: ModulosPage;

  beforeEach(() => {
    page = new ModulosPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
