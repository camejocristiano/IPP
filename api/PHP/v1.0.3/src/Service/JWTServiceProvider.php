<?php
namespace src\Service;

use src\Security\Token;
use Lcobucci\JWT\Builder;
use Lcobucci\JWT\Signer\Hmac\Sha256;
use Pimple\Container;
use Pimple\ServiceProviderInterface;

class JWTServiceProvider implements ServiceProviderInterface
{
	public function register(Container $app)
	{
		$app['jwt'] = function(Container $app) {
			$builder = new Builder();
			$jwt = new Token($builder);

			if($app['signer']) {
				$signer = new Sha256();
				$jwt = new Token($builder, $signer);
			}

			$jwt->setApplication($app);

			return $jwt;
		};
	}
}